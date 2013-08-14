class InstituicoesController < ApplicationController

	layout 'bootstrap'

	def index
		@instituicoes = ActiveRecord::Base.connection.execute("SELECT * FROM instituicoes INNER JOIN cidades on instituicoes.cidade_id = cidades.id INNER JOIN estados on cidades.estados_id = estados.id")
		@instituicoes = @instituicoes.to_a
	end

	def new
		@temp = ActiveRecord::Base.connection.execute("SELECT * FROM cidades INNER JOIN estados on cidades.estados_id = estados.id ORDER BY estados.nome, cidades.nome")
		@cidades = @temp.to_a.collect { |c| ["#{c[4]} &raquo; #{c[1]}".html_safe, c[0]]}
	end

	def create
		if request.post? # TESTE SE O FORMULÁRIO FOI SUBMETIDO
			#ITERAÇÃO PARA ASSOCIAR CAMPOS E VALORES
			fields = []
			values = []
			params[:instituicao].each do |param|
				fields.push(param.first)
				if param.first == 'cnpj' || param.first == 'telefone'
					values.push(ActiveRecord::Base.connection.quote(param.last.gsub(/[^0-9]/, '')))
				else
					values.push(ActiveRecord::Base.connection.quote(param.last))
				end
			end
			# CRIA INSERT BÁSICO PARA SALVAR OS DADOS NO BANCO
			raw_sql = "INSERT INTO instituicoes (#{fields.join(', ')}) VALUES (#{values.join(', ')})"
			# EXECUTA O SQL
			ActiveRecord::Base.connection.execute(raw_sql)
			flash[:notice] = "Instituicao criada com sucesso!"
		end
		redirect_to :action => :index
	end

	def edit
		@temp = ActiveRecord::Base.connection.execute("SELECT * FROM cidades INNER JOIN estados on cidades.estados_id = estados.id ORDER BY estados.nome, cidades.nome")
		@cidades = @temp.to_a.collect { |c| ["#{c[4]} &raquo; #{c[1]}".html_safe, c[0]]}
		@temp = ActiveRecord::Base.connection.execute("SELECT * FROM instituicoes where cnpj = '#{params[:id]}'")
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
			ActiveRecord::Base.connection.execute("DELETE FROM instituicoes WHERE cnpj = '#{params[:id]}'")
			flash[:notice] = "Instituicao excluida com sucesso!"
		end
		redirect_to :action => :index
	end

end
