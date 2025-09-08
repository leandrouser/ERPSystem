import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { LucideAngularModule } from 'lucide-angular';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    RouterModule, LucideAngularModule],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent {
  isCollapsed = false;
  
  menuItens = [
  { label: 'Venda', path: 'sales', icon: 'shopping-cart' },
  { label: 'Pagamento', path: 'payment', icon: 'credit-card' },
  { label: 'Produto', path: 'products', icon: 'package' },
  { label: 'Cliente', path: 'clients', icon: 'users' },
  { label: 'Categoria', path: 'categories', icon: 'tag' },
  { label: 'Relatórios', path: 'reports', icon: 'bar-chart' },
  { label: 'Fechamento de Caixa', path: 'cash-close', icon: 'dollar-sign' }
];

   toggleCollapse() {
    this.isCollapsed = !this.isCollapsed;
  }
}