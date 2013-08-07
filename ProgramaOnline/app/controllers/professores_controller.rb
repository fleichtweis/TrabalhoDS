class ProfessoresController < ApplicationController

	def index
		@professores = ActiveRecord::Base.connection.execute("SELECT * FROM professor JOIN instituicoes_professores ON (professor.id = instituicoes_professores.professores_cpf JOIN instituicoes ON (instituicoes_professores.instituicoes_id = instituicao.id");
		@professores = @professores.to_a
	end

	def new
		@instituicoes = ActiveRecord::Base.connection.execute("SELECT * FROM instituicoes");
		@instituicoes = @insituicoes.to_a
	end

	def create
		if request.post? # TESTE SE O FORMULÁRIO FOI SUBMETIDO
			#ITERAÇÃO PARA ASSOCIAR CAMPOS E VALORES
			fields = []
			values = []
			params[:professor].each do |param|
				fields.push(param.first)
				values.push(ActiveRecord::Base.connection.quote(param.last))
			end
			# CRIA INSERT BÁSICO PARA SALVAR OS DADOS NO BANCO
			raw_sql = "INSERT INTO professores (#{fields.join(', ')}) VALUES (#{values.join(', ')})"
			# EXECUTA O SQL
			ActiveRecord::Base.connection.execute(raw_sql)
			flash[:notice] = "Professor criado com sucesso!"
		end
		redirect_to :action => :index
	end

	def edit
		@instituicoes = ActiveRecord::Base.connection.execute("SELECT * FROM instituicoes");
		@instituicoes = @insituicoes.to_a
		@professor = ActiveRecord::Base.connection.execute("SELECT * FROM professores where id = #{params[:id]}");
	end

	def update
		if request.post? # TESTE SE O FORMULÁRIO FOI SUBMETIDO
			#ITERAÇÃO PARA ASSOCIAR CAMPOS E VALORES
			set = []
			params[:professor].each do |param|
				set.push("#{param.first} = #{ActiveRecord::Base.connection.quote(param.last)}")
			end
			# CRIA INSERT BÁSICO PARA SALVAR OS DADOS NO BANCO
			raw_sql = "UPDATE professores set #{set.join(', ')} WHERE id = #{params[:id]}"
			# EXECUTA O SQL
			ActiveRecord::Base.connection.execute(raw_sql)
			flash[:notice] = "Professor alterado com sucesso!"
		end
		redirect_to :action => :index
	end

	def delete
		if request.post? # TESTE SE O FORMULÁRIO FOI SUBMETIDO
			ActiveRecord::Base.connection.execute("DELETE FROM professores WHERE id = #{params[:id]}")
			flash[:notice] = "Professor excluido com sucesso!"
		end
		redirect_to :action => :index
	end

end
