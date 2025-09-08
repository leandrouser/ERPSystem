import { Component } from '@angular/core';

@Component({
  selector: 'app-cash-close',
  standalone: true,
  template: `
    <h1>Fechamento de Caixa</h1>
    <p>Resumo diário de vendas e caixa.</p>
  `,
  styles: [`
    h1 { color: #4169e1; }
    p { font-size: 1rem; }
  `]
})
export class CashCloseComponent {}
