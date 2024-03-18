interface Phone {
    credito: number;
    numeroChiamate: number;
}

class User implements Phone {
    nome: string;
    cognome: string;
    credito: Phone["credito"];
    numeroChiamate: Phone["numeroChiamate"];

    constructor(_nome: string, _cognome: string, _credito: number, _numeroChiamate: number) {
        this.nome = _nome;
        this.cognome = _cognome;
        this.credito = _credito;
        this.numeroChiamate = _numeroChiamate;
    }

    ricarica(soldi: number) {
        this.credito += soldi;
        return `Ricarica di ${soldi} € effettuata!`;
    }

    chiamata(minuti: number) {
        this.credito -= (minuti * 0.2);
        this.numeroChiamate += minuti
        return `Durata chiamata: ${minuti}; I minuti in chiamata totali sono: ${this.numeroChiamate}`;
    }

    chiama404() {
        return `il credito residuo è ${this.credito}€`;
    }

    getNumeroChiamate() {
        return `I minuti in chiamata totali sono: ${this.numeroChiamate}`;
    }

    azzeraChiamate() {
        this.numeroChiamate = 0
    }

}

let gab = new User('Gabriele', 'Scognamiglio', 10, 0)
console.log(gab.chiamata(50));
console.log(gab.chiamata(12));
console.log(gab.ricarica(150));
console.log(gab.getNumeroChiamate());
console.log(gab.chiama404());