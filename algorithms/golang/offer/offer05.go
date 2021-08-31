package offer

import "strings"

func replaceSpace1(s string) string {
	replace := strings.ReplaceAll(s, " ", "%20")
	return replace
}

func replaceSpace(s string) string {
	// 首先得到扩展数组的大小
	spaceCnt := 0
	for _, str := range s {
		if str == ' ' {
			spaceCnt++
		}
	}
	// 扩展原有数组
	strB := []byte(s)
	tmp := make([]byte, spaceCnt*2)
	strB = append(strB, tmp...)

	pre := len(s)-1
	aft := len(strB)-1
	for pre >= 0 {
		strB[aft] = s[pre]
		if s[pre] == ' ' {
			strB[aft] = '0'
			strB[aft-1] = '2'
			strB[aft-2] = '%'
			aft -= 3
		} else {
			aft--
		}
		pre--
	}
	return string(strB)
}


