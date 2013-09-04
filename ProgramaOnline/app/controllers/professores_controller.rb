class ProfessoresController < ApplicationController

	layout 'bootstrap'

	def index
		@professores = ActiveRecord::Base.connection.execute("SELECT * FROM professores INNER JOIN instituicoes ON professores.instituicoes_cnpj = instituicoes.cnpj");
		@professores = @professores.to_a
	end

	def new
		@instituicoes = ActiveRecord::Base.connection.execute("SELECT * FROM instituicoes INNER JOIN cidades ON instituicoes.cidade_id = cidades.id INNER JOIN estados on cidades.estados_id = estados.id")
		#return render :text => @instituicoes.to_a.inspect
		@instituicoes = @instituicoes.to_a.collect { |i| ["#{i[1]} - #{i[6]} - #{i[10]}".html_safe, i[0].gsub(/[^0-9]/, '')]}
	end

	def create
		if request.post? # TESTE SE O FORMULÁRIO FOI SUBMETIDO
			#ITERAÇÃO PARA ASSOCIAR CAMPOS E VALORES
			fields = []
			values = []
			params[:professor].each do |param|
				fields.push(param.first)
				if param.first == 'cpf'
					values.push(ActiveRecord::Base.connection.quote(param.last.gsub(/[^0-9]/, '')))
				else			
					values.push(ActiveRecord::Base.connection.quote(param.last))
				end
			end
			# CRIA INSERT BÁSICO PARA SALVAR OS DADOS NO BANCO
			raw_sql = "INSERT INTO professores (#{fields.join(', ')}) VALUES (#{values.join(', ')})"
			return render :text => raw_sql.inspect
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
		@professor = ActiveRecord::Base.connection.execute("SELECT * FROM professores where cpf = #{ActiveRecord::Base.connection.quote(params[:id])}");
	end

	def update
		if request.post? # TESTE SE O FORMULÁRIO FOI SUBMETIDO
			#ITERAÇÃO PARA ASSOCIAR CAMPOS E VALORES
			set = []
			params[:professor].each do |param|
				if param.first != 'senha_new' && param.first != 'cpf'
					set.push("#{param.first} = #{ActiveRecord::Base.connection.quote(param.last)}")
				else
					if param.first == 'senha_new' && param.last.present?
						set.push("senha = #{ActiveRecord::Base.connection.quote(param.last)}")
					elsif param.first == 'cpf'
						set.push("#{param.first} = #{ActiveRecord::Base.connection.quote(param.last.gsub(/[^0-9]/, ''))}")
					end
				end
			end
			# CRIA INSERT BÁSICO PARA SALVAR OS DADOS NO BANCO
			raw_sql = "UPDATE professores set #{set.join(', ')} WHERE cpf = #{ActiveRecord::Base.connection.quote(params[:id])}"
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
				ActiveRecord::Base.connection.execute("DELETE FROM professores WHERE cpf = #{ActiveRecord::Base.connection.quote(params[:id])}")
			rescue
				flash[:alert] = "Erro ao excluir professor. Tente novamente!"
				return redirect_to :action => :index
			end
			flash[:notice] = "Professor excluido com sucesso!"
		end
		redirect_to :action => :index
	end

end
