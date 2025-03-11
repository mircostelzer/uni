all: main.out
	@echo “Application compiled”

%.s: %.c
	gcc -S $< -o $@

%.out: %.s
	mkdir -p build
	gcc $< -o build/$@

clean:
	rm -rf build *.out *.s

.PHONY: clean

.SECONDARY: make.s