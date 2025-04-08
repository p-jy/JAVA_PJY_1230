import { Button } from "./Button";
import { useState } from "react";

function StateSample() {
	let [page, setPage] = useState(2);
	let maxPage = 6;

	function decrease() {
		page --;
		if(page < 1) {
			page = maxPage;
		}
		setPage(page - 1);
	}

	const increase = function() {
		page = page + (1);
		if(page > maxPage) {
			page = 1;
		}
		setPage(page);
	}
	function add(amount) {
		page = page + amount;
		if(page < 1) {
			page = maxPage;
		}
		if(page > maxPage) {
			page = 1;
		}
		setPage(page);
	}
	return (
		<div>
			<Button text={"-"} click={()=>add(-1)} />
			<span>{page}</span>
			<span>/{maxPage}</span>
			<Button text={"+"} click={()=>add(1)} />
		</div>
	);
}

export default StateSample;