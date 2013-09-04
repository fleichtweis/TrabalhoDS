class SessionsController < ApplicationController

	layout 'bootstraplogin'

	require 'digest/sha1'

	before_filter :authenticate_user, :only => [:home]

	def login
	end

	def login_attempt
		if request.post? && params[:senha] && params[:cpf]
			encrypted_password= Digest::SHA1.hexdigest(params[:senha])
			user = ActiveRecord::Base.connection.execute("SELECT * FROM professores WHERE cpf = " + ActiveRecord::Base.connection.quote(params[:cpf]) + " AND senha = " + ActiveRecord::Base.connection.quote(params[:senha]))
			user = user.to_a
			if user
				session[:user_id] = user[0]
				flash[:notice] = "Bem-vindo, " + user[1]
				return redirect_to :action => :home
			else
				flash[:alert] = "Usuario invalido!"
				return redirect_to :action => :login
			end
		end
		return redirect_to :action => :login
	end

	def logout
		session[:user_id] = nil
		redirect_to :action => 'login'
	end

end
