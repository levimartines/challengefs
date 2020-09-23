import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {PessoaService} from "./services/pessoa.service";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { PessoasComponent } from './views/pessoas/pessoas.component';

@NgModule({
    declarations: [
        AppComponent,
        PessoasComponent
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
