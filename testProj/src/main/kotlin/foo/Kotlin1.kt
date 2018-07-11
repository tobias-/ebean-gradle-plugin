package foo
            import javax.persistence.Id
            import javax.persistence.MappedSuperclass
            
            @MappedSuperclass
            open class Kotlin1 {
              @Id
              var id: Int? = null
            }
        