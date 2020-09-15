# content Package
## blocks
- contains all java files determining how blocks work (blockStates, what happens when you right-click them etc.)
## models
- contains all java files determining how blocks look (especially baked models)
- open and look into its *package_info.md* for more info about this package
## ClientRegistration
- this is where we register model loaders and stuff that only affects the client (e.g. rendering)
## MoCarpentryPackedHandler
- needed for registering messages, handling packets and sending them
## ModBlocks
- empty right now...
## RegistrationHandler
- this is where we register blocks, items and tile entities
- currently, we do this through DeferredRegisters
- for more info concerning DeferredRegisters, see https://mcforge.readthedocs.io/en/latest/concepts/registries/#deferredregister


*Author: PianoManu*