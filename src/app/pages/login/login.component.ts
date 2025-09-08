import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  rememberMe: boolean = false;
  isLoading: boolean = false;

  constructor(private router: Router) {}

  onLogin() {
    if (this.username && this.password) {
      this.isLoading = true;
      
       setTimeout(() => {
        this.isLoading = false;
        this.router.navigate(['/home']);
      }, 1500);
    }
  }
}