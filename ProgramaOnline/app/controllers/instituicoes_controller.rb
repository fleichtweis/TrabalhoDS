class InstituicoesController < ApplicationController

	def index
		@instituicoes = ActiveRecord::Base.connection.execute("SELECT * FROM instituicoes INNER JOIN cidades on instituicoes.cidade_id = cidades.id INNER JOIN estados on cidades.estados_id = estados.id")
		@instituicoes = @instituicoes.to_a
	end

	def new
		@temp = ActiveRecord::Base.connection.execute("SELECT * FROM estados")
		@estados = @temp.to_a
		@temp = ActiveRecord::Base.connection.execute("SELECT * FROM cidades")
		@cidades = @temp.to_a
	end

	def create
		if request.post? # TESTE SE O FORMULÁRIO FOI SUBMETIDO
			#ITERAÇÃO PARA ASSOCIAR CAMPOS E VALORES
			fields = []
			values = []
			params[:instituicao].each do |param|
				fields.push(ActiveRecord::Base.connection.quote(param.first))
				values.push(ActiveRecord::Base.connection.quote(param.last))
			end
			# CRIA INSERT BÁSICO PARA SALVAR OS DADOS NO BANCO
			raw_sql = "INSERT INTO instituicoes (#{fields.join(', ')}) VALUES (#{values.join(', ')})"
			render text: raw_sql
			# EXECUTA O SQL
			ActiveRecord::Base.connection.execute(raw_sql)
		end
		#redirect_to :action => :index
	end

	def edit
		@temp = ActiveRecord::Base.connection.execute("SELECT * FROM estados")
		@estados = @temp.to_a
		@temp = ActiveRecord::Base.connection.execute("SELECT * FROM cidades")
		@cidades = @temp.to_a
		@temp = ActiveRecord::Base.connection.execute("SELECT * FROM instituicoes where id = #{params[:id]}")
		@instituicao = @temp.to_a
	end

	def update
		if request.post? # TESTE SE O FORMULÁRIO FOI SUBMETIDO
			#ITERAÇÃO PARA ASSOCIAR CAMPOS E VALORES
			set = []
			params[:estado].each do |param|
				set.push("#{param.first} = #{ActiveRecord::Base.connection.quote(param.last)}")
			end
			# CRIA INSERT BÁSICO PARA SALVAR OS DADOS NO BANCO
			raw_sql = "UPDATE estados set #{set.join(', ')} WHERE id = #{params[:id]}"
			# EXECUTA O SQL
			ActiveRecord::Base.connection.execute(raw_sql)
			flash[:notice] = "Instituicao alterada com sucesso!"
		end
		redirect_to :action => :index
	end

	def delete
		if request.post? # TESTE SE O FORMULÁRIO FOI SUBMETIDO
			ActiveRecord::Base.connection.execute("DELETE FROM estados WHERE id = #{params[:id]}")
			flash[:notice] = "Instituicao excluida com sucesso!"
		end
		redirect_to :action => :index
	end

end
