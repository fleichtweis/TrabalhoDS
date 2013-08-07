require 'fileutils'
require 'nokogiri'

class RelatoriosController < ApplicationController

	def index
	end

	def new
	end

	def create
		tmp = params[:relatorio][:my_file].tempfile
		file = File.join("public", params[:relatorio][:my_file].original_filename)
		f = File.open(Rails.root + "/" + file)
		doc = Nokogiri::XML(f)
		f.close
		render text: doc.inspect
	end

	def edit
	end

	def update
	end

	def delete
	end
	
end
