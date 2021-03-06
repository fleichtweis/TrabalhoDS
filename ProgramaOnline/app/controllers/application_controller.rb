class ApplicationController < ActionController::Base
  # Prevent CSRF attacks by raising an exception.
  # For APIs, you may want to use :null_session instead.
  protect_from_forgery with: :exception

	protected
	
		def authenticate_user
			if session[:user_id] && session[:adm] == 1
				raw_sql = "SELECT * FROM administradores WHERE cpf = " + session[:user_id]
				temp = ActiveRecord::Base.connection.execute(raw_sql)
				@current_user = temp.to_a.first
				return true	
			elsif session[:user_id]
				raw_sql = "SELECT * FROM professores WHERE cpf = " + ActiveRecord::Base.connection.quote(session[:user_id])
				temp = ActiveRecord::Base.connection.execute(raw_sql)
				@current_user = temp.to_a.first
				return true	
			else
				redirect_to(:controller => 'sessions', :action => 'login')
				return false
			end
		end
	
		def save_login_state
			if session[:user_id]
				redirect_to(:controller => 'sessions', :action => 'home')
				return false
			else
			return true
		end
	end

end
