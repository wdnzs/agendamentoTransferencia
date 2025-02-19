import { Component, OnInit, signal,ChangeDetectionStrategy} from '@angular/core';
import { MAT_DATE_FORMATS, MAT_DATE_LOCALE, provideNativeDateAdapter } from '@angular/material/core';

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
export class ConteudoComponent implements OnInit{

  protected readonly value = signal('');

  public contaOrigem: string;
  public contaDestino: string;
  public valor: number;
  public dataAgendamento: Date;
  public dataTransferencia: Date;

  protected onInput(event: Event) {
    this.value.set((event.target as HTMLInputElement).value);
  }

  public constructor() {
    this.contaOrigem = "";
    this.contaDestino = "";
    this.valor = 0;
    this.dataAgendamento = new Date();
    this.dataTransferencia = new Date();
  }

  ngOnInit(): void {
  }

  public agendarTransferencia(){

    console.log('Conta Origem:', this.contaOrigem);
    console.log('Conta Destino:', this.contaDestino);
    console.log('Valor:', this.valor);
    console.log('Data Agendamento:', this.formatDate(this.dataAgendamento));
    console.log('Data Transferência:', this.formatDate(this.dataTransferencia));
  }

  private formatDate(date: Date): string {
    return date.toISOString().split('T')[0];

  }

  public extrato() {
    console.log("EXTRATO GERADO!")
  }

}