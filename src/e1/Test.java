package e1;

public class Test {

    /*
     * Considerare il programmino di cui sotto, già funzionante: si provi ad usarlo. 
     * E' realizzato con classe GUI, e interfaccia/implementazione per la logica. 
     * Scopo del task è rifattorizzarlo migliorandone la qualità, e ottenendo un buon 
     * testing delle sue varie parti (non la GUI, solo la Logica!).
     * Si propone il seguente approccio TDD.
     * 
     * Primo passo, sigilliamo LogicsImpl:
     * 1) si scrivano alcuni test che passano su Logics/LogicsImpl, e che ci sembrano
     * catturare il grosso del funzionamento della logica
     * 2) Se nel farlo servono piccole aggiunte a Logics/LogicsImpl le si implementino
     * 3) Non migliorare ora Logics/LogicsImpl, lo faremo dopo
     * 4) Si ri-verifichi il funzionamento del sistema
     * 
     * Ora, iterativamente:
     * 1) si consideri un aspetto dell'implementazione di LogicsImpl che può essere esternalizzato 
     * da LogicsImpl (SRP), ossia inserito in una classe di cui LogicsImpl si comporrà
     * 2) si costruisca l'interfaccia e la sua implementazione con TDD, ossia con vari step di 
     * red-green-refactor sulla nuova classe
     * 3) si tolga il codice da LogicsImpl e si vada ad utilizzare quello nella nuova classe
     * 4) si rilancino i test di LogicsImpl e si facciano anche test a mano sulla GUI
     * 
     * Si proceda così fino a che LogicsImpl non si è significativamente ridotta. A questo punto:
     * 1) si usi TDD per migliorare quel che resta di LogicsImpl
     * 2) si crei un disegno UML del sistema prodotto
     * 
     * Ecco cosa fa il programma: 
     * 
     * Scopo di questo esercizio è realizzare una GUI con l'aspetto mostrato nell'immagine fig.png, fornita, 
     * che contiene una griglia quadrata di pulsanti (5x5), in cui sono presenti un pedone indicato con "*" 
     * e un cavallo indicato con "K", tutti e 2 in posizione iniziale random.
     * 
     * Premendo un pulsante si intende spostare il cavallo in quella posizione, e la cosa funzionerà secondo la
     * regola degli scacchi, dove i cavalli si spostano solo con movimento unico di 2 caselle in una direzione 
     * e 1 in quella perpendicolare.
     * Considerando la figura, dove il cavallo sta in posizione 0-based (4,3), ossia quarta colonna e terza riga,
     * ad esempio potrebbe muoversi solo in 3 caselle, ossia (3,1) mangiando il pedone, (2,2) e (2,4). 
     * Clickando in una posizione valida il cavallo viene spostato, altrimenti non deve succedere nulla.
     * Quando il cavallo va sopra il pedone, si chiuda l'applicazione.
     * 
     *
     */

    public static void main(String[] args) throws java.io.IOException {
        new GUI();
    }
}
