class CidadesController < ApplicationController

	layout 'bootstrap'
	
	def index
		@cidades = ActiveRecord::Base.connection.execute("SELECT * FROM cidades INNER JOIN estados ON cidades.estados_id = estados.id")
		@cidades = @cidades.to_a
	end

	def new
		@estados = ActiveRecord::Base.connection.execute("SELECT * FROM estados")
		@estados = @estados.to_a.collect { |e| [e[1], e[0]]}
	end

	def create
		if request.post? # TESTE SE O FORMULÁRIO FOI SUBMETIDO
			#ITERAÇÃO PARA ASSOCIAR CAMPOS E VALORES
			fields = []
			values = []
			params[:cidade].each do |param|
				fields.push(param.first)
				values.push(ActiveRecord::Base.connection.quote(param.last))
			end
			# CRIA INSERT BÁSICO PARA SALVAR OS DADOS NO BANCO
			raw_sql = "INSERT INTO cidades (#{fields.join(', ')}) VALUES (#{values.join(', ')})"
			# EXECUTA O SQL
			ActiveRecord::Base.connection.execute(raw_sql)
			flash[:notice] = "Cidade criada com sucesso!"
		end
		redirect_to :action => :index
	end

	def edit
		@cidade = ActiveRecord::Base.connection.execute("SELECT * FROM cidades WHERE id = #{params[:id]}")
		@cidade = @cidade.to_a
		@estados = ActiveRecord::Base.connection.execute("SELECT * FROM estados")
		@estados = @estados.to_a.collect { |e| [e[1], e[0]]}
	end

	def update
		if request.post? # TESTE SE O FORMULÁRIO FOI SUBMETIDO
			#render :text => params[:cidade].inspect
			#return
			#ITERAÇÃO PARA ASSOCIAR CAMPOS E VALORES
			set = []
			params[:cidade].each do |param|
				set.push("#{param.first} = #{ActiveRecord::Base.connection.quote(param.last)}")
			end
			# CRIA INSERT BÁSICO PARA SALVAR OS DADOS NO BANCO
			raw_sql = "UPDATE cidades set #{set.join(', ')} WHERE id = #{params[:id]}"
			# EXECUTA O SQL
			ActiveRecord::Base.connection.execute(raw_sql)
			flash[:notice] = "Cidade criada com sucesso!"
		end
		redirect_to :action => :index
	end

	def delete
		if request.post? # TESTE SE O FORMULÁRIO FOI SUBMETIDO
			ActiveRecord::Base.connection.execute("DELETE FROM cidades WHERE id = #{params[:id]}")
			flash[:notice] = "Cidade excluida com sucesso!"
		end
		redirect_to :action => :index
	end
	

end
