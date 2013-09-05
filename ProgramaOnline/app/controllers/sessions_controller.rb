class SessionsController < ApplicationController

	layout 'bootstraplogin'

	require 'digest/sha1'

	before_filter :authenticate_user, :only => [:home]

	def login
	end

	def login_attempt
		if request.post? && params[:senha] && params[:cpf]
			session[:adm] = 0
			encrypted_password = Digest::SHA1.hexdigest(params[:senha])
			if params[:adm]
				raw_sql = "SELECT * FROM administradores WHERE cpf = " + params[:cpf].gsub(/[^0-9]/, '') + " AND senha = " + ActiveRecord::Base.connection.quote(encrypted_password)
				user = ActiveRecord::Base.connection.execute(raw_sql)
				user = user.to_a
				session[:adm] = 1
			else
				raw_sql = "SELECT * FROM professores WHERE cpf = " + ActiveRecord::Base.connection.quote(params[:cpf].gsub(/[^0-9]/, '')) + " AND senha = " + ActiveRecord::Base.connection.quote(encrypted_password)
				user = ActiveRecord::Base.connection.execute(raw_sql)
				user = user.to_a
			end
			if user.length == 1
				session[:user_id] = user.first[0]
				flash[:notice] = "Bem-vindo, " + user.first[1]
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

	def home
		return redirect_to :controller => :estados, :action => :index
	end

end
