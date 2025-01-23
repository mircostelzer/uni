#include <bits/stdc++.h>

using namespace std;

template <typename Item> struct btree {
    Item val;
    btree *parent;
    btree *left;
    btree *right;

    btree(Item v) {
        val = v;
        parent = left = right = nullptr;
    }

    Item read() {
        return val;
    }

    void write(Item v) {
        val = v;
    }

    btree *getParent() {
        return parent;
    }

    btree *getLeft() {
        return left;
    }

    btree *getRight() {
        return right;
    }

    void insertLeft(btree *t) {
        if (left == nullptr) {
            t->parent = this;
            left = t;
        }
    }

    void insertRight(btree *t) {
        if (right == nullptr) {
            t->parent = this;
            right = t;
        }
    }

    void deleteLeft() {
        if (left != nullptr) {
            deleteLeft(left);
            deleteRight(left);
            delete left;
            left = nullptr;
        }
    }

    void deleteRight() {
        if (right != nullptr) {
            deleteLeft(right);
            deleteRight(right);
            delete right;
            right = nullptr;
        }
    }

    void insertNode(Item v) {
        btree<Item> *t = new btree<Item>(v);
        queue<btree<Item> *> q;
        q.push(this);

        while(!q.empty()) {
            btree *u = q.front();
            q.pop();
            btree *l = u->left;
            btree *r = u->right;
            if (l == nullptr) {
                u->insertLeft(t);
                return;
            } else if (r == nullptr) {
                u->insertRight(t);
                return;
            } else {
                q.push(l);
                q.push(r);
            }
        }
    }

    // int countNodes(const btree<int> &t, int lvl=0) {
    //     int res = 0;
    //     if (t != nullptr) {
    //         res = countNodes(t->left, lvl + 1) + countNodes(t->right, lvl + 1);
    //         if (t->val == lvl) {
    //             res++;
    //         }
    //     }
    //     return res;
    // }

    // btree insertNode(btree &t, Item v) {
    //     btree p = nullptr;
    //     btree *u = &t;
    //     if (t == nullptr) {
    //         t = newNode(v);
    //     } else if (v < u.val) {
    //         if (u.left == nullptr) {
    //             u.left = newNode(v);
    //             u->left->parent = u;
    //         } else {
    //             return insertNode(u->left, v);
    //         }
    //     } else if (v > u.val) {
    //         if (u->right == nullptr) {
    //             u->right = newNode(v);
    //             u->right->parent = u;
    //         } else {
    //             return insertNode(u->right, v);
    //         }
    //     }

    //     return t;
    // }
    
};

template <typename Item> void dfs(btree<Item> *t) {
    if (t != nullptr) {

        // uncomment to print in pre-order
        // printf(t.read());

        dfs(t->getLeft());

        // uncomment to print in-order
        cout << t->read() << ' ';
    
        dfs(t->getRight());

        // uncomment to print post-order
        // printf(t.read());

    }
}



int main() {
    btree<int> *t = new btree<int>(0);
    t->insertNode(5);
    t->insertNode(3);
    t->insertNode(1);
    t->insertNode(7);
    t->insertNode(9);

    dfs(t);
}


