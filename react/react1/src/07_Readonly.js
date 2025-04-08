import { useState } from "react";

/*
읽기 버튼 클릭하면 입력창이 읽기 전용으로 변경되고 버튼이 쓰기로 변경됨
쓰기 버튼 클릭하면 입력창이 입력가능으로 변경되고 버튼이 읽기로 변경됨
*/
function ReadOnly() {
	let [text, setText] = useState("읽기");
	let [readOnly, isReadOnly] = useState(false);

	function toggle() {
		isReadOnly(!readOnly);
		if(readOnly) {
			setText("읽기");
		} else {
			setText("쓰기");
		}
	}
	return (
		<div>
			<input readOnly={readOnly} />
			<button onClick={toggle}>{text}</button>
		</div>
	)
}

export default ReadOnly;