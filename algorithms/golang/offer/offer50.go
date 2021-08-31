package offer



func firstUniqChar1(s string) byte {
	mapStr := make(map[byte]int)
	for _, val := range []byte(s) {
		mapStr[val]++
	}
	for _, val := range []byte(s) {
		if mapStr[val] == 1 {
			return val
		}
	}
	return ' '
}


type pair struct {
	ch  byte
	pos int
}

func firstUniqChar(s string) byte {
	n := len(s)
	pos := [26]int{}
	for i := range pos[:] {
		pos[i] = n
	}
	queue := []pair{}
	for i := range s {
		ch := s[i] - 'a'
		// 若是第一次遍历，便加到队尾
		if pos[ch] == n {
			pos[ch] = i
			queue = append(queue, pair{
				ch:  ch,
				pos: i,
			})
		} else {// 否则弹出队首不为一次遍历的元素
			pos[ch] = n+1
			for len(queue) > 0 && pos[queue[0].ch] == n+1 {
				queue = queue[1:]
			}
		}
	}
	if len(queue) > 0 {
		return s[queue[0].pos]
	}
	return ' '
}