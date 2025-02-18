# Cilj
Razumevanje algoritemskih problemov in implementacija s čimmanjšo porabo pomnilnika.

# Opis problema
Uporabniki preko spletne trgovine kupuje izdelke in tako nastanejo naročila s izdelki. Uporabnikom bi radi predlagali sorodnje izdelke za nakup. Algoritem mora delovati po principu sorodnih izdelkov glede na opravljeni nakup.

Primer (u1 - uporabnika 1, p1 - produkt 1) :
* u1 je kupil p1,p2
* u2 je kupil p2,p3. 
Sedaj lahko u1 predlagamo produkt p3 (ker sta s u2 kupila sorodne artikle preko p2). Podobno u2 predlagamo p1.

Da pa ni teh kombinacij preveč, nas zanimajo samo najbolj sorodne relacije. Zato je vpeljan še threshold. Na ta način upoštevamo samo sorodne izdelke, ki so bili med seboj prodani večkrat, kot je vrednost threshold. 

# Testni podatki
## example1.txt
Datoteka vsebuje testne podatke za 7 nakupov. Spodaj so podatem izpisani rezultati za različne vrednosti Threshold. 

## bigcomp_2022_04.txt.zip
Enomesečni podatki za veliko število naročil. Vrednosti so kriptirane zaradi GDPR. ZIP datoteka samo zaradi omejitev github za file upload. 

# Naloga
* spiši program, ki bo prebral vhodno datoteko, poiskal sorodne izdelke in priporočil vrednosti glede na nastavitev trashold. 
* vhod in izhod mora biti točno tak, kot je vpisan v datoteki example1.txt
* stestiraj hitrost delovanja in rezultat na datoteki bigcomp_2022_04.txt

# Pred začetom dela
* naredi si svoj branch in vse spremembe delaj v tem branch
