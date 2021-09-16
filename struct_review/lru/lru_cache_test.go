package lru

import (
	"fmt"
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test_Hostbit(t *testing.T) {
	fmt.Println(hostbit)
}

func Test_LRU(t *testing.T) {
	lru := Constructor(2)

	lru.Put(1, 1)
	lru.Put(2, 2)
	lru.PrintList()
	assert.Equal(t, lru.Get(1), 1)  // returns 1
	lru.PrintList()
	lru.Put(3, 3)
	lru.PrintList()// evicts key 2
	assert.Equal(t, lru.Get(2), -1) // returns -1 (not found)
	lru.Put(4, 4)
	lru.PrintList()
	// evicts key 1
	assert.Equal(t, lru.Get(1), -1) // returns -1 (not found)
	assert.Equal(t, lru.Get(3), 3)  // returns 3
	lru.PrintList()
	assert.Equal(t, lru.Get(4), 4)  // returns 4
	lru.PrintList()
}

func Test_LRU_PutGet(t *testing.T) {
	lru := Constructor(1)

	lru.Put(1, 2)
	lru.PrintList()
	lru.PrintHashList(1)
	assert.Equal(t, lru.Get(1), 2) // returns 2
	lru.PrintList()
}

func Test_LRU_PutGetPutGetGet(t *testing.T) {
	lru := Constructor(1)

	lru.Put(2, 1)
	assert.Equal(t, lru.Get(2), 1) // returns 1
	lru.Put(3, 2)
	assert.Equal(t, lru.Get(2), -1) // returns -1
	assert.Equal(t, lru.Get(3), 2)  // returns 2
}

func Test_LRU_PPGPPG(t *testing.T) {
	lru := Constructor(2)

	lru.Put(2, 1)
	lru.Put(2, 2)
	assert.Equal(t, lru.Get(2), 2) // returns 2
	lru.Put(1, 4)
	lru.Put(4, 1)
	assert.Equal(t, lru.Get(2), -1) // returns -1
	assert.Equal(t, lru.Get(3), -1) // returns -1
}

func Test_LRU_PPGPPG_2(t *testing.T) {
	lru := Constructor(2)

	lru.Put(2, 1)
	lru.Put(2, 2)
	assert.Equal(t, lru.Get(2), 2) // returns 2
	lru.Put(1, 1)
	lru.Put(4, 1)
	assert.Equal(t, lru.Get(2), -1) // returns -1
	assert.Equal(t, lru.Get(3), -1) // returns -1
}


func Test_LRU_PPPP(t *testing.T) {
	lru := Constructor(2)

	lru.Put(2, 1)
	lru.PrintHashList(2)
	lru.Put(2, 2)
	lru.PrintList()
	lru.PrintHashList(1)
	lru.PrintHashList(2)
	lru.Put(1, 4)
	lru.Put(4, 1)
	lru.PrintList()
	lru.PrintHashList(1)
	lru.PrintHashList(2)
	lru.PrintHashList(4)
}