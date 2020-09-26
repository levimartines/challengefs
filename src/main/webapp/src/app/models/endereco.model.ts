import {Cidade} from "./cidade.model";

export interface Endereco {

    id: number;
    pessoa: number;
    logradouro: string;
    numero: number;
    complemento: string;
    bairro: string;
    cidade: Cidade;
}
