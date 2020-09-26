import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ListPessoasComponent} from "./views/list-pessoas/list-pessoas.component";
import {AddPessoaComponent} from "./views/add-pessoa/add-pessoa.component";
import {EditPessoaComponent} from "./views/edit-pessoa/edit-pessoa.component";


const routes: Routes = [
    {
        path: '', component: ListPessoasComponent,
    }, {
        path: 'cadastrar', component: AddPessoaComponent
    }, {
        path: 'pessoa/:id', component: EditPessoaComponent
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
