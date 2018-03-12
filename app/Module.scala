import com.google.inject.AbstractModule
import java.time.Clock

import services.ApplicationTimer

class Module extends AbstractModule {

  override def configure() = {
    bind(classOf[Clock]).toInstance(Clock.systemDefaultZone)
    bind(classOf[ApplicationTimer]).asEagerSingleton()
  }

}
