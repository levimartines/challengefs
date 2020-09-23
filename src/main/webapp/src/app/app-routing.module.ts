import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ListPessoasComponent} from "./views/list-pessoas/list-pessoas.component";
import {AddPessoaComponent} from "./views/add-pessoa/add-pessoa.component";


const routes: Routes = [
    {
        path: '', component: ListPessoasComponent,
    }, {
        path: 'edit/:id', component: AddPessoaComponent
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
