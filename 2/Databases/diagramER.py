from graphviz import Digraph

# Creazione del diagramma ER
er = Digraph("ERDiagram", format="png")
er.attr(rankdir="LR", size="10,7")

# Definizione delle entità principali con attributi
entities = {
    "Elettore": ["codiceFiscale (PK)", "nome", "regione", "ideologia"],
    "Partito": ["nome (PK)", "annoFondazione"],
    "TesseraPartito": ["numero (PK)", "livello", "nomePartito"],
    "Coalizione": ["IDCoalizione (PK)", "ideologia"],
    "AlaPartito": ["nomeAla (PK)", "direttore"],
    "MembroComitato": ["partyId (PK)", "dataInizio", "tipo", "compenso"],
    "Tour": ["IDTour (PK)", "dataInizio"],
    "SostaTour": ["IDSosta (PK)", "luogo", "sequenza", "IDTour (FK)"]
}

# Aggiunta delle entità principali
for entity, attributes in entities.items():
    label = f"<<TABLE BORDER='1' CELLBORDER='0' CELLSPACING='0'>"
    label += f"<TR><TD><B>{entity}</B></TD></TR>"
    for attr in attributes:
        label += f"<TR><TD>{attr}</TD></TR>"
    label += "</TABLE>>"
    er.node(entity, label=label, shape="plaintext")

# Definizione delle relazioni principali
relationships = [
    ("Elettore", "Partito", "Appartenenza", ["dataIscrizione"], "many", "many"),
    ("Elettore", "TesseraPartito", "Possiede", [], "one", "many"),
    ("Partito", "Coalizione", "Appartiene", [], "many", "many"),
    ("Partito", "AlaPartito", "OrganizzatoIn", [], "one", "many"),
    ("Partito", "MembroComitato", "HaComitato", [], "one", "many"),
    ("Coalizione", "MembroComitato", "Compensa", ["elezione"], "many", "many"),
    ("Tour", "MembroComitato", "IncludeCandidato", [], "many", "many"),
    ("Tour", "SostaTour", "HaSoste", [], "one", "many")
]

# Relazioni principali con un miglior layout
for source, target, rel_name, attrs, card1, card2 in relationships:
    rel_label = rel_name + ("\n" + ", ".join(attrs) if attrs else "")
    er.node(rel_name, label=rel_label, shape="diamond")
    er.edge(source, rel_name, label=card1)
    er.edge(rel_name, target, label=card2)

# Salvataggio finale
corrected_er_filepath = "/home/mirco/uni/2/Databases/ERDiagram_Final.png"
er.render(corrected_er_filepath, cleanup=True)
corrected_er_filepath
