.section .text
.global _start
_start:
pushq $1
pushq $2
pushq $3
pushq $4
pushq $5
popq %rbx
popq %rax
pushq %rbx
pushq %rax
popq %rsi
call print
pushq $7
pushq $8
pushq $9
popq %rbx
popq %rax
pushq %rbx
pushq %rax
popq %rsi
call print
exit:

	mov $60,%rax
		xor %rdi, %rdi
	syscall