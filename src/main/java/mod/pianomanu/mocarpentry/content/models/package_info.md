# models Package
## baked
- contains all java files determining the block models, especially baked models
- for more info concerning baked models, take a look at baked_models.md
## geometry
- needed by every ModelLoader (one ModelGeometry per ModelLoader and vice versa)
- every ModelGeometry is responsible for the corresponding BakedModel and creates a new instance of the said BakedModel
## loader
- every registered loader (registered in ClientRegistration class) needs its own ModelLoader, which again needs its own ModelGeometry, which again needs its own BakedModel
- that means, we have (ideally) the same amount of loaders as baked models and (in this mod) the same amount of registered blocks


*Author: PianoManu*
