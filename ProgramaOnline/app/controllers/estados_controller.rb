class EstadosController < ApplicationController

	before_filter :authenticate_user

	layout 'bootstrap'

	def index
		@estados = ActiveRecord::Base.connection.execute("SELECT * FROM estados")
		@estados = @estados.to_a
	end

	def new
	end

	def create
		if request.post? # TESTE SE O FORMULÁRIO FOI SUBMETIDO
			#ITERAÇÃO PARA ASSOCIAR CAMPOS E VALORES
			fields = []
			values = []
			params[:estado].each do |param|
				fields.push(param.first)
				values.push(ActiveRecord::Base.connection.quote(param.last.strip))
			end
			# CRIA INSERT BÁSICO PARA SALVAR OS DADOS NO BANCO
			raw_sql = "INSERT INTO estados (#{fields.join(', ')}) VALUES (#{values.join(', ')})"
			# EXECUTA O SQL
			begin
				ActiveRecord::Base.connection.execute(raw_sql)
			rescue
				flash[:alert] = "Erro ao criar o estado. Tente novamente!"
				return redirect_to :action => :index
			end
			flash[:notice] = "Estado criado com sucesso!"
		end
		redirect_to :action => :index
	end

	def edit
		@estado = ActiveRecord::Base.connection.execute("SELECT * FROM estados WHERE id = #{params[:id]}")
		@estado = @estado.to_a
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
			begin
				ActiveRecord::Base.connection.execute(raw_sql)
			rescue
				flash[:alert] = "Erro ao editar o estado. Tente novamente!"
				return redirect_to :action => :index
			end
			flash[:notice] = "Estado alterado com sucesso!"
		end
		redirect_to :action => :index
	end

	def delete
		if request.post? # TESTE SE O FORMULÁRIO FOI SUBMETIDO
			begin
				ActiveRecord::Base.connection.execute("DELETE FROM estados WHERE id = #{params[:id]}")
			rescue
				flash[:alert] = "Erro ao excluir o estado. Tente novamente!"
				return redirect_to :action => :index
			end
			flash[:notice] = "Estado excluido com sucesso!"
		end
		redirect_to :action => :index
	end

end
