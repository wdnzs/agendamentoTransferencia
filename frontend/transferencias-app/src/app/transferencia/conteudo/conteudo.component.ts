import { HttpClient } from '@angular/common/http';
import {
  Component,
  OnInit,
  signal,
  ChangeDetectionStrategy,
} from '@angular/core';
import {
  MAT_DATE_LOCALE,
  provideNativeDateAdapter,
} from '@angular/material/core';

@Component({
  selector: 'app-conteudo',
  standalone: false,
  templateUrl: './conteudo.component.html',
  styleUrl: './conteudo.component.css',
  providers: [
    provideNativeDateAdapter(),
    { provide: MAT_DATE_LOCALE, useValue: 'pt-BR' },
  ],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ConteudoComponent implements OnInit {
  protected readonly value = signal('');

  public contaOrigem: string = '';
  public contaDestino: string = '';
  public valor: number = 0;
  public dataAgendamento: Date | null = null;
  public dataTransferencia: Date | null = null;

  protected onInput(event: Event) {
    this.value.set((event.target as HTMLInputElement).value);
  }

  public constructor(private http: HttpClient) {}

  ngOnInit(): void {}

  public agendarTransferencia() {
    // Verifica se as datas foram informadas pelo usuário
    if (!this.dataAgendamento || !this.dataTransferencia) {
      console.error('Datas de agendamento e transferência são obrigatórias.');
      return;
    }

    // Formata as datas para o formato ISO (YYYY-MM-DD)
    const transferData = {
      contaOrigem: this.contaOrigem,
      contaDestino: this.contaDestino,
      valor: this.valor,
      dataAgendamento: this.formatDate(this.dataAgendamento),
      dataTransferencia: this.formatDate(this.dataTransferencia),
    };

    console.log('Dados da transferência:', transferData);

    // Envia os dados para a API
    this.http
      .post('http://localhost:8080/transferencia', transferData)
      .subscribe(
        (response) => {
          console.log('Transferência realizada com sucesso:', response);
        },
        (error) => {
          console.error('Erro ao realizar transferência:', error);
          if (error.status) {
            console.error(`Status do erro: ${error.status}`);
            console.error(`Mensagem do erro: ${error.message}`);
          }
        }
      );
  }

  private formatDate(date: Date): string {
    return date.toISOString().split('T')[0];
  }

  public extrato() {
    this.http.get('http://localhost:8080/listarTransferencias').subscribe(
      (response) => {
        console.log('Transferências:', response);
      },
      (error) => {
        console.error('Erro ao listar transferências:', error);
      }
    );
  }
}
