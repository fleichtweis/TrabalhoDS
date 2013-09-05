class RelatoriosController < ApplicationController

	before_filter :authenticate_user

	require 'fileutils'

	layout 'bootstrap'

	def index
	end

	def new
	end

	def create
		uploaded_io = params[:relatorio][:arquivo]
  		File.open(Rails.root.join('public', 'uploads', uploaded_io.original_filename), 'w') do |file|
    			file.write(uploaded_io.read)
  		end
		file = "#{Rails.root}/public/uploads/#{uploaded_io.original_filename}"
		hash = Hash.from_xml(file)
		return render :text => hash.inspect
	end
	def edit
	end

	def update
	end

	def delete
	end
	
end
