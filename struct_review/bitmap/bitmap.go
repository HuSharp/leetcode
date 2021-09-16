package bitmap

type BitMap []byte

func New(length uint) BitMap {
	return make([]byte, length/8 + 1)
}

// Set
func (bitmap BitMap) Set(val uint) {
	byteIndex := val / 8
	if byteIndex >= uint(len(bitmap)) {
		return
	}
	bitIndex := val % 8
	[]byte(bitmap)[byteIndex] |= 1<<bitIndex
}

// Get
func (bitmap BitMap) Get(val uint) bool {
	byteIndex := val / 8
	if byteIndex >= uint(len(bitmap)) {
		return false
	}
	bitIndex := val % 8
	return []byte(bitmap)[byteIndex] & (1<<bitIndex) != 0
}