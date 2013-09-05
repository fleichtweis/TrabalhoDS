class RelatoriosController < ApplicationController

	before_filter :authenticate_user

	require 'fileutils'

	layout 'bootstrap'

	def index
		@avaliacoes = ActiveRecord::Base.connection.execute("SELECT * FROM avaliacoes INNER JOIN alunos ON avaliacoes.aluno_id = alunos.id")
		@avaliacoes = @avaliacoes.to_a
	end

	def new
	end

	def create
		uploaded_io = params[:relatorio][:arquivo]
  		File.open(Rails.root.join('public', 'uploads', uploaded_io.original_filename), 'w') do |file|
    			file.write(uploaded_io.read)
  		end
		file = File.open("#{Rails.root}/public/uploads/#{uploaded_io.original_filename}", "r")
		contents = file.read
		hash = Hash.from_xml(contents)
		relatorio = hash.first
		relatorio.each do |lista, dados|
			return render :text => lista.inspect
		end
		return render :text => relatorio.inspect
	end
	def edit
	end

	def update
	end

	def delete
	end
	
end
