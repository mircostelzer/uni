#!/usr/bin/env bash
nargs=$(( $#-1 ));
lista=($@);
while [[ $nargs -ge 0 ]]; do
	echo ${lista[$nargs]};
	(( nargs-- ));
done
