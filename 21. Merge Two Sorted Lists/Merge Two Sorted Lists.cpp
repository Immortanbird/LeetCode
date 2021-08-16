/* 
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 */
#include <iostream>

using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution
{
public:
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2)
    {
        if (l1 == nullptr)
            return l2;
        if (l2 == nullptr)
            return l1;

        ListNode *L, *p;
        if (l1->val < l2->val)
        {
            L = l1;
            p = l2;
        }
        else
        {
            L = l2;
            p = l1;
        }

        ListNode *q = L;

        while (p)
        {
            if (L->next)
            {
                if (L->next->val >= p->val)
                {
                    ListNode *q = p->next;
                    p->next = L->next;
                    L->next = p;
                    p = q;
                    L = L->next;
                }
                else
                    L = L->next;
            }
            else
            {
                L->next = p;
                break;
            }
        }

        return q;
    }
};

int main()
{
    ListNode *l1 = new ListNode(1);

    ListNode *l2 = new ListNode(2);

    Solution s;
    ListNode *p = s.mergeTwoLists(l1, l2);

    while (p)
    {
        cout << p->val << endl;
        p = p->next;
    }

    return 0;
}