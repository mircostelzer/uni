import matplotlib.pyplot as plt # type: ignore
import networkx as nx #type: ignore

# Function to visualize the graph
def visualize_graph(graph):
    # Convert the given Graph object to a networkx graph
    G = nx.DiGraph()  # Use DiGraph for a directed graph

    for u in graph.V():
        for v, w in graph.adj(u).items():
            G.add_edge(u, v, weight=w)

    # Create a layout for the graph
    pos = nx.spring_layout(G)

    # Draw the nodes
    nx.draw_networkx_nodes(G, pos, node_size=700, node_color="skyblue")

    # Draw the edges
    nx.draw_networkx_edges(G, pos, edge_color="gray", arrows=True)

    # Add labels to nodes
    nx.draw_networkx_labels(G, pos, font_size=12, font_color="black")

    # Add edge labels for weights
    edge_labels = nx.get_edge_attributes(G, 'weight')
    nx.draw_networkx_edge_labels(G, pos, edge_labels=edge_labels, font_color="red")

    # Show the plot
    plt.title("Graph Visualization")
    plt.axis("off")
    plt.savefig('graph.png')


class Graph:
    def __init__(self):
        self.nodes = {}

    def V(self):
        return self.nodes.keys()

    def size(self):
        return len(self.nodes)
    
    def adj(self, u):
        if u in self.nodes:
            return self.nodes[u]
        
    def insertNode(self, u):
        if u not in self.nodes:
            self.nodes[u] = {}

    def insertEdge(self, u, v, w=0):
        self.insertNode(u)
        self.insertNode(v)
        self.nodes[u][v] = w


g = Graph()

for u, v in [('a', 'b'), ('a', 'd'), ('b', 'c'), ('d', 'a'), ('d', 'c'), ('d', 'e'), ('e', 'c')]:
    g.insertEdge(u, v)

g.insertNode('f')


for u in g.V():
    print(u, "->", g.adj(u))

visualize_graph(g)