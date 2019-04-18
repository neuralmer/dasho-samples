.PHONY: default
default: build show

.PHONY: build
build:
	./gradlew clean assembleRelease > build.log

.PHONY: unapk
unapk:
	@$(RM) -r unapk > unapk.log
	@mkdir unapk >> unapk.log
	@( cd unapk ; unzip ../build/outputs/apk/release/DebuggingOnAndroid-release.apk ) >> unapk.log
	@mkdir unapk/unjar >> unapk.log
	@( cd unapk ; d2j-dex2jar.sh classes.dex 2>&1 ) >> unapk.log
	@( cd unapk/unjar ; jar xvf ../classes-dex2jar.jar ) >> unapk.log

.PHONY: show
show: unapk
	@echo "R8 or ProGuard:"
	@grep 'android.enableR8' gradle.properties
	@echo "proguard-rules.pro:"
	@cat proguard-rules.pro
	@echo ""
	@echo "mapping:"
	@cat build/outputs/mapping/release/mapping.txt \
		| sed -n '/^com[.]dasho[.]android[.]debug[.]other[.]ApplicationLogic ->/,/^[^ ]/p'
	@echo ""
	@echo "output:"
	@javap -c -v -p -s -l -constants unapk/unjar/$$(cat build/outputs/mapping/release/mapping.txt \
			| sed -n 's,^com[.]dasho[.]android[.]debug[.]other[.]ApplicationLogic -> \(.*\):,\1,p' \
			| sed 's,[.],/,g').class \
		| sed -n '/^{$$/,/^}$$/p' \
		| grep --text '^  [A-Za-z0-9_]'
	@echo ""
