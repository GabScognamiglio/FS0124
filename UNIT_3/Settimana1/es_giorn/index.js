var User = /** @class */ (function () {
    function User(_nome, _cognome, _credito, _numeroChiamate) {
        this.nome = _nome;
        this.cognome = _cognome;
        this.credito = _credito;
        this.numeroChiamate = _numeroChiamate;
    }
    User.prototype.ricarica = function (soldi) {
        this.credito += soldi;
        return "Ricarica di ".concat(soldi, " \u20AC effettuata!");
    };
    User.prototype.chiamata = function (minuti) {
        this.credito -= (minuti * 0.2);
        this.numeroChiamate += minuti;
        return "Durata chiamata: ".concat(minuti, "; I minuti in chiamata totali sono: ").concat(this.numeroChiamate);
    };
    User.prototype.chiama404 = function () {
        return "il credito residuo \u00E8 ".concat(this.credito, "\u20AC");
    };
    User.prototype.getNumeroChiamate = function () {
        return "I minuti in chiamata totali sono: ".concat(this.numeroChiamate);
    };
    User.prototype.azzeraChiamate = function () {
        this.numeroChiamate = 0;
    };
    return User;
}());
var gab = new User('Gabriele', 'Scognamiglio', 10, 0);
console.log(gab.chiamata(50));
console.log(gab.chiamata(12));
console.log(gab.ricarica(150));
console.log(gab.getNumeroChiamate());
console.log(gab.chiama404());
