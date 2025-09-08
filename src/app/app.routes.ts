import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { SalesComponent } from './pages/vendas/sales.component';
import { PaymentsComponent } from './pages/pagamentos/payments.component';
import { ProductsComponent } from './pages/produtos/products.component';
import { ClientsComponent } from './pages/clientes/clients.component';
import { CategoriesComponent } from './pages/categorias/categories.component';
import { ReportsComponent } from './pages/relatorios/reports.component';
import { CashCloseComponent } from './pages/caixas/cash-close.component';
import { LoginComponent } from './pages/login/login.component';


export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  {
    path: 'home',
    component: HomeComponent,
    children: [
      { path: '', redirectTo: 'sales', pathMatch: 'full' },
      { path: 'sales', component: SalesComponent },
      { path: 'payment', component: PaymentsComponent },
      { path: 'products', component: ProductsComponent },
      { path: 'clients', component: ClientsComponent },
      { path: 'categories', component: CategoriesComponent },
      { path: 'reports', component: ReportsComponent },
      { path: 'cash-close', component: CashCloseComponent }
    ]
  },
   { 
    path: '', 
    redirectTo: 'login', 
    pathMatch: 'full' 
  },
  { 
    path: '**', 
    redirectTo: 'login' 
  }
];