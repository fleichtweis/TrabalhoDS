class RelatoriosController < ApplicationController

	def index
	end

	def new
	end

	def create
		render text: params[:post].inspect
	end

	def edit
	end

	def update
	end

	def delete
	end
	
end
