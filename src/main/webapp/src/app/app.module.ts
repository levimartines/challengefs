import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {PessoaService} from "./services/pessoa.service";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {ListPessoasComponent} from './views/list-pessoas/list-pessoas.component';
import {AddPessoaComponent} from './views/add-pessoa/add-pessoa.component';

@NgModule({
    declarations: [
        AppComponent,
        ListPessoasComponent,
        AddPessoaComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule
    ],
    providers: [PessoaService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
