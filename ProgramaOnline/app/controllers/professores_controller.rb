class ProfessoresController < ApplicationController

	layout 'bootstrap'

	def index
		@professores = ActiveRecord::Base.connection.execute("SELECT * FROM professores INNER JOIN instituicoes_has_professores ON professores.cpf = instituicoes_has_professores.professores_cpf JOIN instituicoes ON instituicoes_has_professores.instituicoes_cnpj = instituicoes.cnpj");
		@professores = @professores.to_a
	end

	def new
		@instituicoes = ActiveRecord::Base.connection.execute("SELECT * FROM instituicoes INNER JOIN cidades ON instituicoes.cidade_id = cidades.id INNER JOIN estados on cidades.estados_id = estados.id")
		@instituicoes = @insituicoes.to_a.collect { |i| ["#{c[4]} &raquo; #{c[1]}".html_safe, i[0]]}
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
			begin
				ActiveRecord::Base.connection.execute(raw_sql)
			rescue
				flash[:alert] = "Erro ao cadastrar o professor. Tente novamente!"
				return redirect_to :action => :index
			end
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
			begin
				ActiveRecord::Base.connection.execute(raw_sql)
			rescue
				flash[:alert] = "Erro ao editar o professor. Tente novamente!"
				return redirect_to :action => :index
			end
			flash[:notice] = "Professor alterado com sucesso!"
		end
		redirect_to :action => :index
	end

	def delete
		if request.post? # TESTE SE O FORMULÁRIO FOI SUBMETIDO
			begin
				ActiveRecord::Base.connection.execute("DELETE FROM professores WHERE id = #{params[:id]}")
			rescue
				flash[:alert] = "Erro ao excluir professor. Tente novamente!"
				return redirect_to :action => :index
			end
			flash[:notice] = "Professor excluido com sucesso!"
		end
		redirect_to :action => :index
	end

end
