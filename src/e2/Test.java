package e2;

public class Test {

    /*
     * Scopo di questo esercizio è realizzare una GUI con l'aspetto mostrato nell'immagine f1.png, fornita, 
     * che realizza un clone del gioco campo minato -- si veda https://minesweeper.online/it/ per un recap del gioco.
     * Qui si dovrà realizzare lo stesso gioco, ossia:
     * - all'inizio si designa la posizione delle mine, il cui numero è indicato nel secondo agomento del costruttore della GUI
     * - clickando su una cella che contiene una mina, il gioco termina mostrando la posizione delle mine
     * - clickando su una cella che NON contiene una mina, si disabilita la cella e si mostra il numero delle mine 
     * in immediata  adiacenza (ossia in una delle celle 8 celle adiacenti, in orizzontale, verticale o diagonale)
     * - se si è clickata una cella senza mine in adiacenza, si proceda "auto-clickando" tutti i vicini, ricorsivamente
     * (si noti che la figura p1.png mostra cosa succede col colo click nella cella 0,0 in alto/sinistra)
     * - se si è riusciti a disabilitare tutte le celle tranne le mine, l'applicazione mostri un messaggio di vittoria
     * (vedere figura final.png)
     * 
     * 
     * Si fornisce del codice di partenza, ossia una GUI minimale già impostata per intercettare gli eventi e gestirli.
     * L'oggetto di questo task è di definire i metodi dell'interfaccia Logics, e implementarla con una classe LogicsImpl 
     * in modo che il gioco sia funzionante. Obiettivi di qualità generale, e specifici come sotto indicato, potrebbero 
     * portare ad avere ulteriori classi/interfacce di cui LogicsImpl si compone, o che comunque usa.
     * 
     * DISCLAIMER: esiste una soluzione con classe unica LogicsImpl di 80 righe (ma voi dovete fare meglio!!)
     * 
     * Si usi in modo impeccabile TDD. Tempo stimato per lo studente: da 2 a 3 ore.
     * 
     * Si propongono le seguenti tappe intermedie e incrementali di sviluppo:
     * 1) dispongo le mine in modo random 
     * 2) al primo click do subito partita persa mostrandole
     * 3) se uno clicka su una mina do subito partita persa mostrandole, altrimenti riclicka
     * 4) se uno clicka e non prende la mina, disabilito la cella
     * 5) se uno clicka e non prende la mina, disabilito la cella, ma mostro anche quante mine adiacenti ci sono
     * 6) se uno clicka e non prende la mina, e non ci sono mine adiacenti, procedo con gli auto-click
     * 7) gestisco posizionamento bandierina con right-click su cella come nel gioco originale
     * 
     * Si noti che quelli sopra non sono obiettivi per il singolo ciclo red-greed-refactor, che sono generalmente
     * molto più "corti". 
     * 
     * Come obiettivi di qualità, si prenda spunto da quanto segue:
     * 0) Cercare qualità nella logica, non tanto nella GUI -- non è una legge generale, è solo per il task di oggi
     * 1) Si cerchi di non violare mai DRY!
     * 2) Se un metodo non è del tutto chiaro e semplice, trovare una diversa organizzazione, magari spezzando in più metodi
     * 3) Se una classe viola SRP, la si divida in più classi (magari usando pattern quali PROXY, Template Method, Strategy, o mera composizione)
     * 4) Non soffrire di "primitive obsession", cercando di NON abusare di booleani, interi e stringhe, usando tipi ad-hoc
     * 
     * Spunti "architetturali":
     * 1) modellare la posizione di una cella con una interfaccia/classe Cell, che catturi i concetti di adiacenza
     * 2) modellare la griglia con una interfaccia/classe Grid
     *
     */

    public static void main(String[] args) {
        new GUI(7);
    }
}
