
msg ?= 
B ?=

msg_required:
ifndef msg
	@echo commit message is required
	@exit 1
else
	@echo 
endif

branch_required:
ifndef B:
	@echo branch name is required
	@exit 1
else
endif

branch: 
	git checkout master
	git pull --all
	git branch $(B) 
	git checkout $(B)
	git pull --all

push: msg_required
	git add .
	git commit -m "$(msg)"
	git push