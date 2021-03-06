ProgramaOnline::Application.routes.draw do
  #get "sessions/login,"
  #get "sessions/home,"
  #get "sessions/profile,"
  #get "sessions/setting"
  # The priority is based upon order of creation: first created -> highest priority.
  # See how all your routes lay out with "rake routes".

  # You can have the root of your site routed with "root"
  # root 'welcome#index'

  # Example of regular route:
  #   get 'products/:id' => 'catalog#view'

  # Example of named route that can be invoked with purchase_url(id: product.id)
  #   get 'products/:id/purchase' => 'catalog#purchase', as: :purchase

  # Example resource route (maps HTTP verbs to controller actions automatically):
  #   resources :products

  # Example resource route with options:
  #   resources :products do
  #     member do
  #       get 'short'
  #       post 'toggle'
  #     end
  #
  #     collection do
  #       get 'sold'
  #     end
  #   end

  # Example resource route with sub-resources:
  #   resources :products do
  #     resources :comments, :sales
  #     resource :seller
  #   end

  # Example resource route with more complex sub-resources:
  #   resources :products do
  #     resources :comments
  #     resources :sales do
  #       get 'recent', on: :collection
  #     end
  #   end
  
  # Example resource route with concerns:
  #   concern :toggleable do
  #     post 'toggle'
  #   end
  #   resources :posts, concerns: :toggleable
  #   resources :photos, concerns: :toggleable

  # Example resource route within a namespace:
  #   namespace :admin do
  #     # Directs /admin/products/* to Admin::ProductsController
  #     # (app/controllers/admin/products_controller.rb)
  #     resources :products
  #   end
 
  ## PROFESSORES ##
  get 'professores' => 'professores#index'
  get 'professores/cadastro' => 'professores#new'
  get 'professores/:id' => 'professores#edit'
  post 'professores/create' => 'professores#create'
  post 'professores/update/:id' => 'professores#update'
  post 'professores/delete/:id' => 'professores#delete'

  ## INSTITUIÇÕES ##
  get 'instituicoes' => 'instituicoes#index'
  get 'instituicoes/nova' => 'instituicoes#new'
  get 'instituicoes/:id' => 'instituicoes#edit'
  post 'instituicoes/create' => 'instituicoes#create'
  post 'instituicoes/update/:id' => 'instituicoes#update'
  post 'instituicoes/delete/:id' => 'instituicoes#delete'

  ## RELATÓRIOS ##
  get 'relatorios' => 'relatorios#index'
  get 'relatorios/novo' => 'relatorios#new'
  get 'relatorios/:id' => 'relatorios#edit'
  post 'relatorios/create' => 'relatorios#create'

  ## CIDADES ##
  get 'cidades' => 'cidades#index'
  get 'cidades/nova' => 'cidades#new'
  get 'cidades/:id' => 'cidades#edit'
  post 'cidades/create' => 'cidades#create'
  post 'cidades/update/:id' => 'cidades#update'
  post 'cidades/delete/:id' => 'cidades#delete'

  ## ESTADOS ##
  get 'estados' => 'estados#index'
  get 'estados/novo' => 'estados#new'
  get 'estados/:id' => 'estados#edit'
  post 'estados/create' => 'estados#create'
  post 'estados/update/:id' => 'estados#update'
  post 'estados/delete/:id' => 'estados#delete'

  ## ADMINISTRADORES ##
  get 'administradores' => 'administradores#index'
  get 'administradores/novo' => 'administradores#new'
  get 'administradores/:id' => 'administradores#edit'
  post 'administradores/create' => 'administradores#create'
  post 'administradores/update/:id' => 'administradores#update'
  post 'administradores/delete/:id' => 'administradores#delete'

  ## LOGIN ##
  get 'login' => 'sessions#login'
  get 'home' => 'sessions#home'
  get 'logout' => 'sessions#logout'
  post 'sessions/login_attempt' => 'sessions#login_attempt'

end
