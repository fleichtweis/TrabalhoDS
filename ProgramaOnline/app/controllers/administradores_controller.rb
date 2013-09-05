class AdministradoresController < ApplicationController

	before_filter :authenticate_user

	require 'digest/sha1'

	layout 'bootstrap'

	def index
		@administradores = ActiveRecord::Base.connection.execute("SELECT * FROM administradores")
		@administradores = @administradores.to_a
	end

	def new
	end

	def create
		if request.post? # TESTE SE O FORMULÁRIO FOI SUBMETIDO
			#ITERAÇÃO PARA ASSOCIAR CAMPOS E VALORES
			fields = []
			values = []
			params[:administrador].each do |param|
				fields.push(param.first)
				if param.first != 'senha' && param.first != 'cpf'
					values.push(ActiveRecord::Base.connection.quote(param.last))
				else
					if param.first == 'cpf'
						values.push(ActiveRecord::Base.connection.quote(param.last.gsub(/[^0-9]/, '')))
					elsif param.first == 'senha'
						values.push(ActiveRecord::Base.connection.quote(Digest::SHA1.hexdigest(param.last)))
					end
				end
			end
			# CRIA INSERT BÁSICO PARA SALVAR OS DADOS NO BANCO
			raw_sql = "INSERT INTO administradores (#{fields.join(', ')}) VALUES (#{values.join(', ')})"
			# EXECUTA O SQL
			begin
				ActiveRecord::Base.connection.execute(raw_sql)
			rescue
				flash[:alert] = "Erro ao cadastrar administrador. Tente novamente!"
				return redirect_to :action => :index
			end
			flash[:notice] = "Administrador cadastrado com sucesso!"
		end
		redirect_to :action => :index
	end

	def edit
		@temp = ActiveRecord::Base.connection.execute("SELECT * FROM administradores where cpf = '#{params[:id]}'")
		@administrador = @temp.to_a
	end

	def update
		if request.post? # TESTE SE O FORMULÁRIO FOI SUBMETIDO
			#ITERAÇÃO PARA ASSOCIAR CAMPOS E VALORES
			set = []
			params[:administrador].each do |param|
				if param.first != 'senha_new' && param.first != 'cpf'
					set.push("#{param.first} = #{ActiveRecord::Base.connection.quote(param.last)}")
				else
					if param.first == 'senha_new' && param.last.present?
						set.push("#{param.first} = #{ActiveRecord::Base.connection.quote(Digest::SHA1.hexdigest(param.last))}")
					elsif param.first == 'cpf'
						set.push("senha = #{ActiveRecord::Base.connection.quote(param.last)}")
					end
				end
			end
			# CRIA INSERT BÁSICO PARA SALVAR OS DADOS NO BANCO
			raw_sql = "UPDATE administradores set #{set.join(', ')} WHERE id = #{params[:id]}"
			# EXECUTA O SQL
			begin
				ActiveRecord::Base.connection.execute(raw_sql)
			rescue
				flash[:alert] = "Erro ao editar administrador. Tente novamente!"
				return redirect_to :action => :index
			end
			flash[:notice] = "Administrador alterado com sucesso!"
		end
		redirect_to :action => :index
	end

	def delete
		if request.post? # TESTE SE O FORMULÁRIO FOI SUBMETIDO
			begin
				ActiveRecord::Base.connection.execute("DELETE FROM administradores WHERE cpf = '#{params[:id]}'")
			rescue
				flash[:alert] = "Erro ao excluir administrador. Tente novamente!"
				return redirect_to :action => :index
			end
			flash[:notice] = "Administrador excluido com sucesso!"
		end
		redirect_to :action => :index
	end
end
