class InstituicoesController < ApplicationController

	def index
	end

	def new
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
			#ActiveRecord::Base.connection.execute(raw_sql)
		end
		#redirect_to :action => :index
	end

	def edit
	end

	def update
	end

	def delete
	end

end
