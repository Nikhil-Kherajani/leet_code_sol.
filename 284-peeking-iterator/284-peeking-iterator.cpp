class PeekingIterator : public Iterator {
public:
	PeekingIterator(const vector<int>& nums) :
		Iterator(nums),
		m_pNext(nullptr),
		m_hasNext(false)
	{
		// Initialize any member here.
		// **DO NOT** save a copy of nums and manipulate it directly.
		// You should only use the Iterator interface methods.
		m_pNext = new int;
		*m_pNext = Iterator::next();
		m_hasNext = true;
	}

	~PeekingIterator()
	{
		if (nullptr != m_pNext)
		{
			delete m_pNext;
			m_pNext = nullptr;
		}
	}

	// Returns the next element in the iteration without advancing the iterator.
	int peek() {
		return *m_pNext;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	int next() {
		int i = *m_pNext;

		if (Iterator::hasNext())
		{
			delete m_pNext;
			m_pNext = new int;
			*m_pNext = Iterator::next();
			m_hasNext = true;
		}
		else
		{
			m_hasNext = false;
		}

		return i;
	}

	bool hasNext()
	{
		return m_hasNext;
	}

private:
	int* m_pNext;
	bool m_hasNext;
};