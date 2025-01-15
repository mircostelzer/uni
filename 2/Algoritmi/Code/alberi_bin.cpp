

template <typename Item> struct btree{
    Item val;
    btree *parent;
    btree *left;
    btree *right;


    btree *Tree(Item v) {
        btree *t = new btree;
        t->parent = t->left = t->right = nullptr;
        t->val = v;
        return t;
    }

    btree *parent(const btree &t) {
        if (t != nullptr) return t->parent;
        return nullptr;
    }

    
};




int main() {
    btree<int> *t = new btree<int>;
    t = t->Tree(0);
}



int countNodes(btree<int> *&t, int lvl=0) {
    int res = 0;
    if (t != nullptr) {
        res = countNodes(t->left, lvl + 1) + countNodes(t->right, lvl + 1);
        if (t->val == lvl) {
            res++;
        }
    }
    return res;
}